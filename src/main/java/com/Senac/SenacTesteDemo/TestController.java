package com.Senac.SenacTesteDemo;
import java.util.Scanner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//anotação
//Classe
@Controller
@RequestMapping("/Senac")
public class TestController {

    //passage,m de parametro via @Pathvarriable
    @ResponseBody
    @GetMapping ("/{id}")
    public String getId(@PathVariable long id){
        return "Meu id é : "  + id;

    }



//@ResponseBody
    //metodos
    //@GetMapping("/Teste")
    // public String retornaNome(){
    // return "teste123";

   @ResponseBody
    @GetMapping ("/Teste2")

   // lembrar maiusculo e minusculo igual ao codigo
    public String metodoTeste (){
        Scanner entrada =new Scanner(System.in);
        String retorno = entrada.nextLine();
        if (retorno.equals("teste")){
            return "Teste 123456";

        }else {
            return "caiu no else";
        }
    }
}