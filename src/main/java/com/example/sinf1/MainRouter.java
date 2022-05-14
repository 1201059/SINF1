package com.example.sinf1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.sinf1.model.Cliente;
import com.example.sinf1.model.DAL;
import com.example.sinf1.model.Faturacao;
import com.example.sinf1.model.Gestor;
import com.example.sinf1.model.Lugar;
import com.example.sinf1.model.Marca;
import com.example.sinf1.model.Reserva;
import com.example.sinf1.model.Viatura;
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
        int nrFiscal = Integer.parseInt(rc.request().getParam("nrFiscal"));
        int veiculo = Integer.parseInt(rc.request().getParam("veiculo"));
        int cod = Integer.parseInt(rc.request().getParam("cod"));
        Cliente cliente = new Cliente(nome, sobreNome, email, password, nrFiscal);
        dal.insereCliente(cliente);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addViatura(RoutingContext rc){
        String tipoViatura  = rc.request().getParam("tipoViatura");
        String matricula = rc.request().getParam("matricula");
        String modelo = rc.request().getParam("modelo");
        Date dataAdesao = new Date();
        try {
            DateFormat format = new SimpleDateFormat("DD,MM,YYYY");
            String date = rc.request().getParam("dataAdesao");
            dataAdesao = format.parse(date);
        }catch (ParseException e){
            System.out.println(e);
        }
        Viatura viatura = new Viatura(tipoViatura,matricula, modelo, dataAdesao);
        dal.insereViatura(viatura);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addReserva(RoutingContext rc){
        Date dataReserva = new Date();
        try {
            DateFormat format = new SimpleDateFormat("DD,MM,YYYY");
            String date = rc.request().getParam("dataReserva");
            dataReserva = format.parse(date);
        }catch (ParseException e){
            System.out.println(e);
        }
        int tempo  = Integer.parseInt(rc.request().getParam("tempo"));
        int custo = Integer.parseInt(rc.request().getParam("custo"));
        String email = rc.request().getParam("email");
        Reserva reserva = new Reserva(dataReserva, custo, tempo, email);
        dal.insereReserva(reserva);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addLugar(RoutingContext rc){
        int numero = Integer.parseInt(rc.request().getParam("numero"));
        boolean ocupacao = Boolean.parseBoolean(rc.request().getParam("ocupacao"));
        int tempoSegundos = Integer.parseInt(rc.request().getParam("tempoSegundos"));
        Lugar lugar = new Lugar(numero, ocupacao, tempoSegundos);
        dal.insereLugar(lugar);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addFaturacao(RoutingContext rc){
        Date dataFatura = new Date();
        try {
            DateFormat format = new SimpleDateFormat("DD,MM,YYYY");
            String date = rc.request().getParam("dataFatura");
            dataFatura = format.parse(date);
        }catch (ParseException e){
            System.out.println(e);
        }
        int custo = Integer.parseInt(rc.request().getParam("custo"));
        int tempoEstacionado = Integer.parseInt(rc.request().getParam("tempoEstacionado"));
        String email = rc.request().getParam("email");
        Faturacao faturacao = new Faturacao(dataFatura, custo, tempoEstacionado, email);
        dal.insereFaturacao(faturacao);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addGestor(RoutingContext rc){
        int cod = Integer.parseInt(rc.request().getParam("cod"));
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