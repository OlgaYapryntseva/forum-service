package telran.java48.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import telran.java48.account.model.UserAccount;


public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

}
