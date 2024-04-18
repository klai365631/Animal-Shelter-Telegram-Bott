package skypro.teamproject.animalsheltertelegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * Interface ReportDataRepository.
 */
@Repository
public interface ReportDataRepository extends JpaRepository<ReportData, Long> {

    Collection<ReportData> findListByChatId(Long id);

    Optional<ReportData> findByChatId(Long id);

    Optional<ReportData> findFirstByChatIdOrderByLastMessageDesc(Long id);

}
