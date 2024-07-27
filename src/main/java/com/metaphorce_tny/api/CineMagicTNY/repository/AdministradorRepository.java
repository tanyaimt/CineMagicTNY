package com.metaphorce_tny.api.CineMagicTNY.repository;

import com.metaphorce_tny.api.CineMagicTNY.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*import java.util.List;*/

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador,Long> {


}
