package com.mihalkovich.entrance_campaign.repository

import com.mihalkovich.entrance_campaign.entity.Faculty
import com.mihalkovich.entrance_campaign.entity.Speciality
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpecialityRepository: JpaRepository<Speciality, Long>{
    fun findByNameAndFaculty(name: String?, faculty: Faculty): Speciality
}