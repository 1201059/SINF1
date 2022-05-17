package com.example.sinf1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.sinf1.model.Cliente;
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

import static com.example.sinf1.model.DAL.*;

public class MainRouter extends AbstractVerticle {

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
        int cod = Integer.parseInt(rc.request().getParam("codigo"));
        String nome = rc.request().getParam("nome");
        String sobreNome = rc.request().getParam("sobrenome");
        String email = rc.request().getParam("email");
        String password = rc.request().getParam("password");
        int nrFiscal = Integer.parseInt(rc.request().getParam("nrFiscal"));
        int veiculo = Integer.parseInt(rc.request().getParam("veiculo"));
        Cliente cliente = new Cliente(email, password, cod, nrFiscal, veiculo, nome, sobreNome);
        insereCliente(cliente);
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
        insereViatura(viatura);
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
        int cod  = Integer.parseInt(rc.request().getParam("codigo"));
        int tempo  = Integer.parseInt(rc.request().getParam("tempo"));
        int custo = Integer.parseInt(rc.request().getParam("custo"));
        String email = rc.request().getParam("email");
        Reserva reserva = new Reserva(cod, dataReserva, custo, tempo, email);
        insereReserva(reserva);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addLugar(RoutingContext rc){
        int numero = Integer.parseInt(rc.request().getParam("numero"));
        boolean ocupacao = Boolean.parseBoolean(rc.request().getParam("ocupacao"));
        int tempoSegundos = Integer.parseInt(rc.request().getParam("tempoSegundos"));
        Lugar lugar = new Lugar(numero, ocupacao, tempoSegundos);
        insereLugar(lugar);
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
        int cod  = Integer.parseInt(rc.request().getParam("codigo"));
        int custo = Integer.parseInt(rc.request().getParam("custo"));
        int tempoEstacionado = Integer.parseInt(rc.request().getParam("tempoEstacionado"));
        String email = rc.request().getParam("email");
        Faturacao faturacao = new Faturacao(cod, dataFatura, custo, tempoEstacionado, email);
        insereFaturacao(faturacao);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addGestor(RoutingContext rc){
        int cod = Integer.parseInt(rc.request().getParam("codigo"));
        String email = rc.request().getParam("email");
        String password = rc.request().getParam("password");
        Gestor gestor = new Gestor(cod, email, password);
        insereGestor(gestor);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }

    public void addMarca(RoutingContext rc){
        String nome = rc.request().getParam("nome");
        Marca marca = new Marca(nome);
        insereMarca(marca);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok"); 
    }



















}   