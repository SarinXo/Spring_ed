//package spring_ed.config;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.ConstructorBinding;
//
//import java.util.List;
//
////@Getter
////@Setter
////@NoArgsConstructor
//@Value
//@ConstructorBinding
//@ConfigurationProperties(prefix = "db")
//public class YamlDatabaseConfigProperties {
//    //поля должны полностью совпадать!!!
//    //все поля после Value - private final
//    String username;
//    String password;
//    String driver;
//    String url;
//    List<String> hosts;
//    Pool pool;
//
////    @Getter
////    @Setter
////    @NoArgsConstructor
//    @Value
//    public static class Pool{
//        int size;
//        List<Integer> massiv;
//        List<Vars> complex_massiv;
//
////        @Getter
////        @Setter
////        @NoArgsConstructor
//        @Value
//        public static class Vars{
//            int var1;
//            int var2;
//            int var3;
//        }
//    }
//
//}
