package com.example.sinf1;

import com.example.sinf1.Model.Cliente;
import com.example.sinf1.Model.DAL;
import com.example.sinf1.Model.Faturacao;
import com.example.sinf1.Model.Gestor;
import com.example.sinf1.Model.Lugar;
import com.example.sinf1.Model.Marca;
import com.example.sinf1.Model.Reserva;
import com.example.sinf1.Model.Viatura;
import com.example.utilitarios.Data;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;


public class MainRouter extends AbstractVerticle {
    private DAL dal = new DAL();

    public void start(Promise<Void> startPromise) throws Exception{
        HttpServer httpServer = vertx.createHttpServer();
        Router router = Router.router(vertx);

        router.get("/").handler(StaticHandler.create());

        httpServer.requestHandler(router)
            .listen(8888, http -> {
                if(http.failed()){
                    System.out.println("HTTP Server error on port 8888" + http.cause());
                    startPromise.fail(http.cause());
                    return;
                }
                System.out.println("HTTP Server started on port 8888");
                startPromise.complete();
            });
    }

    public void stop(){
        System.out.println("---> SINF1 stop! ");
    }

    public void addCliente(RoutingContext rc){
        String nome = rc.request().getParam("nome");
        String sobreNome = rc.request().getParam("sobrenome");
        String email = rc.request().getParam("email");
        String password = rc.request().getParam("password");
        int nrFiscal = rc.request().getParam("nrFiscal");
        int veiculo = rc.request().getParam("veiculo");
        int cod = rc.request().getParam("cod");
        Cliente cliente = new Cliente(nome, sobreNome, email, password, nrFiscal);
        dal.insereCliente(cliente);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addViatura(RoutingContext rc){
        String tipoViatura  = rc.request().getParam("tipoViatura");
        String matricula = rc.request().getParam("matricula");
        String modelo = rc.request().getParam("modelo");
        int dataDia = rc.request().getParam("dataDia");
        int dataMes = rc.request().getParam("dataMes");
        int dataAno = rc.request().getParam("dataAno");
        Viatura viatura = new Viatura(tipoViatura,matricula, modelo, new Data(dataDia,dataMes,dataAno));
        dal.insereViatura(viatura);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addReserva(RoutingContext rc){
        int dataDia = rc.request().getParam("dataDia");
        int dataMes = rc.request().getParam("dataMes");
        int dataAno = rc.request().getParam("dataAno");
        int tempo  = rc.request().getParam("tempo");
        int custo = rc.request().getParam("custo");
        String email = rc.request().getParam("email");
        Reserva reserva = new Reserva(new Data(dataDia,dataMes,dataAno), custo, tempo, email);
        dal.insereReserva(reserva);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addLugar(RoutingContext rc){
        int numero = rc.request().getParam("numero");
        boolean ocupacao = rc.request().getParam("ocupacao");
        int tempoSegundos = rc.request().getParam("tempoSegundos");
        Lugar lugar = new Lugar(numero, ocupacao, tempoSegundos);
        dal.insereLugar(lugar);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addFaturacao(RoutingContext rc){
        int dataDia = rc.request().getParam("dataDia");
        int dataMes = rc.request().getParam("dataMes");
        int dataAno = rc.request().getParam("dataAno");
        int custo = rc.request().getParam("custo");
        int tempoEstacionado = rc.request().getParam("tempoEstacionado");
        String email = rc.request().getParam("email");
        Faturacao faturacao = new Faturacao(new Data(dataDia,dataMes,dataAno), custo, tempoEstacionado, email);
        dal.insereFaturacao(faturacao);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addGestor(RoutingContext rc){
        int cod = rc.request().getParam("cod");
        String email = rc.request().getParam("email");
        String password = rc.request().getParam("password");
        Gestor gestor = new Gestor(cod, email, password);
        dal.insereGestor(gestor);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addMarca(RoutingContext rc){
        String nome = rc.request().getParam("nome");
        Marca marca = new Marca(nome);
        dal.insereMarca(marca);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }



















}   