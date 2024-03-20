package koo.spring_data_redis_utilization.loginSession.repository;

import koo.spring_data_redis_utilization.loginSession.domain.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
}
