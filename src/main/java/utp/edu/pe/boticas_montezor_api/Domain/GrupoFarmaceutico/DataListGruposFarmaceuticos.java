package utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico;

public record DataListGruposFarmaceuticos(
        Long id,
        String nombre
) {
    public DataListGruposFarmaceuticos(GrupoFarmaceutico data){
        this(
                data.getId(),
                data.getNombre()
        );
    }
}
