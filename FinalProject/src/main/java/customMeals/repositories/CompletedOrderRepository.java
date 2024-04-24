package customMeals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import customMeals.beans.CompletedOrder;

public interface CompletedOrderRepository extends JpaRepository<CompletedOrder, Long> {
}
