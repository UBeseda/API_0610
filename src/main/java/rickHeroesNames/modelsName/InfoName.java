package rickHeroesNames.modelsName;

import com.fasterxml.jackson.annotation.JsonInclude;

public class InfoName {
    public int count;
    public int pages;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String next;
    public Object prev;
}
