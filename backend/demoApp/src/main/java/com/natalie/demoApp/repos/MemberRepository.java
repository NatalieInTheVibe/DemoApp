package com.natalie.demoApp.repos;

import com.natalie.demoApp.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Long>{

}
