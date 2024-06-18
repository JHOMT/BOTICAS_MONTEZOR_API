package utp.edu.pe.boticas_montezor_api.Services;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras.DataListDistribuidora;
import utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras.DistribuidoraRepository;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.DataListFormaFarmaceutica;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.FormaFarmaceuticaRepository;
import utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico.DataListGruposFarmaceuticos;
import utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico.GrupoFarmaceuticoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.Laboratorios.DataListLaboratorios;
import utp.edu.pe.boticas_montezor_api.Domain.Laboratorios.LaboratorioRepository;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.DataListPrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private GrupoFarmaceuticoRepository grupoFarmaceuticoRepository;
    @Autowired
    private FormaFarmaceuticaRepository formaFarmaceuticaRepository;
    @Autowired
    private LaboratorioRepository laboratorioRepository;
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;
    @Autowired
    private PrincipioActivoRepository principioActivoRepository;

    public Boolean registrar(@NotNull DataRegisterProducto producto) {
        Optional<Producto> productoOptional = productoRepository.findByNombreAndLaboratorio(producto.nombre(), producto.laboratorioId());
        Producto productoNuevo = new Producto();
        if (productoOptional.isPresent()) {
            productoNuevo= productoOptional.get();
            productoNuevo.setCantidad(productoNuevo.getCantidad() + producto.cantidad());
        }else{
            productoNuevo = new Producto(producto);
        }
        productoRepository.save(productoNuevo);
        return true;
    }
    public Boolean actualizar(@NotNull DataUpdateProducto producto) {
        Optional<Producto> productoOptional = Optional.ofNullable(productoRepository.findById(producto.id())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado")));
        productoRepository.save(new Producto(producto));
        return true;
    }
    public List<DataListProductos> listar() {
        return productoRepository.findAll().stream().map(DataListProductos::new).toList();
    }
    public List<DataListGruposFarmaceuticos> listarGruposFarmaceuticos() {
        return grupoFarmaceuticoRepository.findAll().stream().map(DataListGruposFarmaceuticos::new).toList();
    }
    public List<DataListFormaFarmaceutica> listarFormaFarmaceutica() {
        return formaFarmaceuticaRepository.findAll().stream().map(DataListFormaFarmaceutica::new).toList();
    }
    public List<DataListLaboratorios> listarLaboratorios() {
        return laboratorioRepository.findAll().stream().map(DataListLaboratorios::new).toList();
    }
    public List<DataListDistribuidora> listarDistribuidoras() {
        return distribuidoraRepository.findAll().stream().map(DataListDistribuidora::new).toList();
    }
    public List<DataListPrincipioActivo> listarPrincipiosActivos() {
        return principioActivoRepository.findAll().stream().map(DataListPrincipioActivo::new).toList();
    }
}
