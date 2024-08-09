package com.metaphorce_tny.api.CineMagicTNY.services;

import com.metaphorce_tny.api.CineMagicTNY.model.Boleto;
import java.util.List;

public interface IBoletoService {

    List<Boleto> listarBoleto();
    Boleto buscarPorId(Long id_boleto);
    Boleto crearBoleto(Boleto boleto);
    Boleto actualizarBoleto(Long id_boleto, Boleto boleto);
    void eliminarBoleto(Long id_boleto);
}
