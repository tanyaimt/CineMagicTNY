package com.metaphorce_tny.api.CineMagicTNY.repository;

import com.metaphorce_tny.api.CineMagicTNY.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*import java.util.List;*/

@Repository
public interface BoletoRepository extends JpaRepository<Boleto,Long> {


}
