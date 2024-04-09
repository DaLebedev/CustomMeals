package customMeals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import customMeals.beans.Side;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Apr 9, 2024
 */
public interface SideRepository extends JpaRepository<Side, Long> {

}
