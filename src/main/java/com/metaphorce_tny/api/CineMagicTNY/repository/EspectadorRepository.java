package com.metaphorce_tny.api.CineMagicTNY.repository;

import com.metaphorce_tny.api.CineMagicTNY.model.Espectador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspectadorRepository extends JpaRepository<Espectador,Long> {


}
