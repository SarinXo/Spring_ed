package spring_ed.config.condition;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "db")
public record RecordYamlDbProperties(String userName,
                                     String password,
                                     String driver,
                                     String url,
                                     List<String>hosts,
                                     Pool pool) {
    public record Pool(int size,
                       List<Integer> massiv,
                       List<Vars> complexMassiv){
        public record Vars(int var1,
                           int var2,
                           int var3){

        }
    }
}
