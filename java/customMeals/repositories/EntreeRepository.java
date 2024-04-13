package customMeals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import customMeals.beans.Entree;

public interface EntreeRepository extends JpaRepository<Entree, Long> {
}
