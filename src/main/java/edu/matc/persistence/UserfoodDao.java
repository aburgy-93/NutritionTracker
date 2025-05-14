package edu.matc.persistence;

import edu.matc.entity.UserFood;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Userfood dao.
 */
public class UserfoodDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Gets meals grouped by meal time sorted by date.
     *
     * @param userId the user id
     * @return the meals grouped by meal time sorted by date
     */
    public Map<String, List<UserFood>> getMealsGroupedByMealTimeSortedByDate(int userId) {
        Map<String, List<UserFood>> groupedMeals = new HashMap<>();

        try (Session session = getSession()) {
            String hql = "FROM UserFood uf WHERE uf.user.id = :userId";
            List<UserFood> allMeals = session.createQuery(hql, UserFood.class)
                    .setParameter("userId", userId)
                    .getResultList();

            groupedMeals = allMeals.stream()
                    .collect(Collectors.groupingBy(UserFood::getMealTime));

            groupedMeals.forEach((mealType, meals) ->
                    meals.sort(Comparator.comparing(meal -> LocalDate.parse(meal.getDate())))
            );
        } catch (Exception e) {
            logger.debug("Error: " + e.getMessage());
        }

        return groupedMeals;
    }
}
