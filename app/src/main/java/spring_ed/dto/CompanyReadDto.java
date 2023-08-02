package spring_ed.dto;

public class CompanyReadDto {
    private final Integer id;

    public CompanyReadDto(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
}
