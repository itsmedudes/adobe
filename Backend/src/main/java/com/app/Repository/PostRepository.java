package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.Model.Post;
import com.app.Model.User;

public interface PostRepository extends JpaRepository<Post,Long>{
	
	@Query("SELECT u FROM Post p JOIN User u on p.user.id = u.id GROUP BY u.id ORDER BY count(p) DESC limit 5")
	List<User> findTopFiveAticveUser();
	
	@Query("from Post order by likes Desc Limit 5")
	List<Post> findTopFiveLikedPost();
}
