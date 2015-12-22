package com.xyInc.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;

import com.xyInc.dao.PontoDeInteresseDAO;
import com.xyInc.entity.CadastroResponseStatus;
import com.xyInc.entity.PontoDeInteresse;
import com.xyInc.util.PontoDeInteresseUtils;

@Path("pontosDeInteresse")
public class Servicos {

    @GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PontoDeInteresse> buscaTodos(){
    	List<PontoDeInteresse> pontos = new PontoDeInteresseDAO().listaPontosDeInteresse();
    	return pontos;
    }
    
    @GET
    @Path("nada")
    public String buscaNada(){
    	return "Esse vai!";
    }

    @GET
    @Path("proximos/{x}/{y}/{dMax}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PontoDeInteresse> buscaProximos(@PathParam("x") int x, @PathParam("y") int y, @PathParam("dMax") double dMax){
    	List<PontoDeInteresse> todosPontos = new PontoDeInteresseDAO().listaPontosDeInteresse();
    	return PontoDeInteresseUtils.filtraDistancia(todosPontos, new PontoDeInteresse(x,y), dMax);
    }
    
    @POST
    @Path("cadastro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluirPontoDeInteresse(PontoDeInteresse poi){
    	if(poi.getX()==null || poi.getX()<=0 || poi.getY()==null || poi.getY()<=0){
    		return Response.status(CadastroResponseStatus.ERRO_COORD_NEGATIVAS.getHttpStatus())
    				.entity(CadastroResponseStatus.ERRO_COORD_NEGATIVAS.getMensagem())
    				.build();
    	}
    	if(poi.getNome()==null || poi.getNome().isEmpty()){
    		return Response.status(CadastroResponseStatus.ERRO_NOME_VAZIO.getHttpStatus())
    				.entity(CadastroResponseStatus.ERRO_NOME_VAZIO.getMensagem())
    				.build();
    	}
    	
    	PontoDeInteresseDAO pontoInteresseDao = new PontoDeInteresseDAO();
    	try{
    		Long id = pontoInteresseDao.save(poi);
    		poi.setId(id);
    		return Response.status(CadastroResponseStatus.SUCCESS.getHttpStatus()).entity(poi).build();
    	}catch(HibernateException e){
    		e.printStackTrace();
    		return Response.status(CadastroResponseStatus.ERRO_ACESSO_BANCO.getHttpStatus())
    				.entity(CadastroResponseStatus.ERRO_COORD_NEGATIVAS.getMensagem())
    				.build();
    	}
    	
    }

}