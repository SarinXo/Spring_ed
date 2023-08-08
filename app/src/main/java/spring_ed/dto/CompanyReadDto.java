package spring_ed.dto;

public class CompanyReadDto {
    private final Integer id;

    public CompanyReadDto(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CompanyReadDto)
            return this.id.equals( ((CompanyReadDto) obj).id);
        return false;
    }
}
