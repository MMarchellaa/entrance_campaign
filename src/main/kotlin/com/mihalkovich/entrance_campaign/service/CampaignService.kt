package com.mihalkovich.entrance_campaign.service

import com.mihalkovich.entrance_campaign.dto.EnrolleeDto
import com.mihalkovich.entrance_campaign.dto.ResultsDto
import com.mihalkovich.entrance_campaign.entity.Faculty
import com.mihalkovich.entrance_campaign.entity.Speciality
import com.mihalkovich.entrance_campaign.entity.University
import com.mihalkovich.entrance_campaign.repository.FacultyRepository
import com.mihalkovich.entrance_campaign.repository.SpecialityRepository
import com.mihalkovich.entrance_campaign.repository.UniversityRepository
import org.springframework.stereotype.Service

@Service
class CampaignService(
    val specialityRepository: SpecialityRepository,
    val facultyRepository: FacultyRepository,
    val universityRepository: UniversityRepository,
    val rabbitMQSender: RabbitMQSender
) {
    fun campaign(enrolleDto: EnrolleeDto) {
        var resultsDto = ResultsDto(enrolleDto.name, enrolleDto.patronymic, enrolleDto.surname, enrolleDto.telephoneNumber, enrolleDto.email)
        var rating = 0
        val university: University = universityRepository.findByName(enrolleDto.dreamSpeciality?.university)
        val faculty: Faculty = facultyRepository.findByNameAndUniversity(enrolleDto.dreamSpeciality?.faculty, university)
        val speciality: Speciality = specialityRepository.findByNameAndFaculty(enrolleDto.dreamSpeciality?.speciality, faculty)
        speciality.requiredExams?.forEach{
            if (enrolleDto.testingResults?.containsKey(it.name) == true){
                rating+= enrolleDto.testingResults!![it.name]!!
            }
        }
        rating+= Integer.parseInt(enrolleDto.averageRating?.replace(".", ""))
        if (rating >= speciality.passingRating!!){
            println("Прошел)0))0")
            resultsDto.result = true
            rabbitMQSender.send(resultsDto)
            return
        }

        println("Не прошел((")
        resultsDto.result = false
        rabbitMQSender.send(resultsDto)
        return
    }
}