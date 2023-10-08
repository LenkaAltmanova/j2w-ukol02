package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Controller

public class MainController {
    private final Random random = new Random();
    @GetMapping("/")


    /*private static List<String> readAllLines(String resource) throws IOException{
        //Soubory z resources se získávají pomocí classloaderu. Nejprve musíme získat aktuální classloader.
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        //Pomocí metody getResourceAsStream() získáme z classloaderu InpuStream, který čte z příslušného souboru.
        //Následně InputStream převedeme na BufferedRead, který čte text v kódování UTF-8
        try(InputStream inputStream=classLoader.getResourceAsStream("templates.citaty.txt");
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8))){

            //Metoda lines() vrací stream řádků ze souboru. Pomocí kolektoru převedeme Stream<String> na List<String>.
            return reader
                    .lines()
                    .collect(Collectors.toList());
        }
    }

    public ModelAndView zmenCitat() {
        ModelAndView result = new ModelAndView("index");
        result.addObject("templates.citaty.txt");
        return result;
    }*/

    public ModelAndView zmenCitat() {
        List<String> seznamTextu=List.of("The Classic Mystery Game where you are the detective, the victim, and the murderer.",
                "A user interface is like a joke. If you have to explain it, it's not that good.",
                "To replace programmers with robots, clients will have to accurately describe what they want. We're safe.",
                "I have a joke on programming but it only works on my computer.",
                "99 little bugs in the code, 99 bugs in the code. Take one down, patch it around. 127 little bugs in the code…",
                "When I wrote this code, only God & I understood what it did. Now… Only God knows.",
                "Programmer (noun.): A machine that turns coffee into code.",
                "Real programmers count from 0.");
        int nahodneCislo = random.nextInt(seznamTextu.size());
        String nahodnyText = seznamTextu.get(nahodneCislo);
        ModelAndView result = new ModelAndView("index");
        result.addObject("nahodnyText", nahodnyText);
        return result;
    }

}
