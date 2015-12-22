package com.xyInc.test;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.xyInc.entity.PontoDeInteresse;

import junit.framework.Assert;

public class TesteServicos extends JerseyTest {

    public TesteServicos()throws Exception {
        super("com.xyInc.ws");
    }

    @Test
    @SuppressWarnings("unchecked")
	public void testeListaTodos() {
        WebResource webResource = resource();
        ArrayList<PontoDeInteresse> lista = ( ArrayList<PontoDeInteresse>) webResource.path("pontosDeInteresse/todos").get(ArrayList.class);
        Assert.assertEquals(lista.size(), 5);
    }

    @Test
    public void salvaERecupera() {
        WebResource webResource = resource();
        PontoDeInteresse poi1 = new PontoDeInteresse("Local Teste",10,21);
        ClientResponse resp = webResource.path("pontosDeInteresse/cadastro").type(MediaType.APPLICATION_JSON).post(ClientResponse.class, poi1);
        PontoDeInteresse poi2 = resp.getEntity(PontoDeInteresse.class);
        Assert.assertEquals(poi1.getNome(), poi2.getNome());
        Assert.assertEquals(poi1.getX(), poi2.getX());
        Assert.assertEquals(poi1.getY(), poi2.getY());
    }

}
