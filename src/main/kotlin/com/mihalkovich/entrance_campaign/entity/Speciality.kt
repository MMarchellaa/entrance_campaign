package com.mihalkovich.entrance_campaign.entity

import javax.persistence.*

@Entity
@Table(name = "speciality")
data class Speciality(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @ManyToOne
    @JoinColumn(name = "faculty", nullable = false)
    var faculty: Faculty? = null,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "speciality_id")
    var requiredExams: MutableList<Exams>? = mutableListOf(),

    @Column(name = "passing_rating", nullable = false)
    var passingRating: Int? = null
)
