package oaie.io.wimmservice.elasticsearch;

import oaie.io.wimmservice.dto.BankTransactionDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BankTransactionRepository extends ElasticsearchRepository<BankTransactionDTO, String> {
}
