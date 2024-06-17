package utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica;

public record DataListFormaFarmaceutica(
        Long id,
        String nombre
) {
    public DataListFormaFarmaceutica(FormaFarmaceutica data){
        this(
                data.getId(),
                data.getNombre()
        );
    }
}
