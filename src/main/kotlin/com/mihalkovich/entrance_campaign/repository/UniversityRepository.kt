package com.mihalkovich.entrance_campaign.repository

import com.mihalkovich.entrance_campaign.entity.University
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UniversityRepository: JpaRepository<University, Long>{
    fun findByName(name: String?): University
}