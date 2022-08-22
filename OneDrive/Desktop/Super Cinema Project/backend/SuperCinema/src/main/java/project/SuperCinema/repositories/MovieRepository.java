package project.SuperCinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.SuperCinema.entities.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query("FROM Movie WHERE title = :title ")
    Movie findMovieByTitle(String title);
    @Query("FROM Movie  AS m WHERE m.id = ?1 ")
    Movie findMovieById(Long id);


    @Transactional
    @Modifying
    void deleteMovieById(Long id);




}
