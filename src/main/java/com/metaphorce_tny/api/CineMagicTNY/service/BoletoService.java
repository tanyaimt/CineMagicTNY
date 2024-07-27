package com.metaphorce_tny.api.CineMagicTNY.service;

import com.metaphorce_tny.api.CineMagicTNY.model.Boleto;
import com.metaphorce_tny.api.CineMagicTNY.repository.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletoService implements IBoletoService {
    @Autowired
    private BoletoRepository boletoRepository;

    @Override
    public List<Boleto> listarBoleto() {
        return boletoRepository.findAll();
    }

    @Override
    public Boleto buscarPorId(Long id_boleto) {
        return boletoRepository.findById(id_boleto).orElse(null);
    }

    @Override
    public Boleto crearBoleto(Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    @Override
    public Boleto actualizarBoleto(Long id_boleto, Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    @Override
    public void eliminarBoleto(Long id_boleto) {
        boletoRepository.deleteById(id_boleto);
    }

    // TODO: Implement methods for CRUD operations
}
