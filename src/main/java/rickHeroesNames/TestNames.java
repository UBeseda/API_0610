package rickHeroesNames;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;
import rickHeroesNames.modelsName.NamesModel;
import rickHeroesNames.modelsName.ResultName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestNames {
    static String url = "https://rickandmortyapi.com/api/character";
    static List<String> listUrls = new ArrayList<>(); //cписок всіх сторінок
    static ObjectMapper on;
    @BeforeClass
    public static void startData() throws JsonProcessingException {
        listUrls.add(url);
        on= new ObjectMapper();
        while (true) {
            NamesModel namesModel = on.readValue(RestGet.GetExchange(url), NamesModel.class);
            if (!Objects.equals(namesModel.info.next, null)) {
                listUrls.add(namesModel.info.next);
                url = namesModel.info.next;
            } else {
                break;
            }
        }
        for (String l : listUrls) {
            System.out.println(l);
        }
    }


    @Test
    public void test() throws JsonProcessingException {
        for (String l:listUrls){
            NamesModel model=on.readValue(RestGet.GetExchange(l), NamesModel.class);
            for(ResultName r:model.results){
                System.out.println("------------------------------");
                System.out.println(r);
            }
        }
    }
}