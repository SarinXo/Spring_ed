package spring_ed.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class YamlDatabaseConfigProperties {
    //поля должны полностью совпадать!!!
    private String username;
    private String password;
    private String driver;
    private String url;
    private List<String> hosts;
    private Pool pool;

    @Getter
    @Setter
    @NoArgsConstructor
    private static class Pool{
        private int size;
        private List<Integer> massiv;
        private List<Vars> complex_massiv;

        @Getter
        @Setter
        @NoArgsConstructor
        private static class Vars{
            private int var1;
            private int var2;
            private int var3;
        }
    }

}
