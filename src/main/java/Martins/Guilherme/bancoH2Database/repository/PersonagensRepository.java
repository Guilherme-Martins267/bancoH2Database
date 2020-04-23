package Martins.Guilherme.bancoH2Database.repository;

import Martins.Guilherme.bancoH2Database.model.PersonagensEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagensRepository extends CrudRepository<PersonagensEntity, Long> {
}
