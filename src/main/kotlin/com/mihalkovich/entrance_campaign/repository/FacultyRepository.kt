package com.mihalkovich.entrance_campaign.repository

import com.mihalkovich.entrance_campaign.entity.Faculty
import com.mihalkovich.entrance_campaign.entity.University
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FacultyRepository: JpaRepository<Faculty, Long>{
    fun findByNameAndUniversity(name: String?, university: University): Faculty
}