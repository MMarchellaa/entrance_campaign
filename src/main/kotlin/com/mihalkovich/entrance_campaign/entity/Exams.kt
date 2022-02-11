package com.mihalkovich.entrance_campaign.entity

import javax.persistence.*

@Entity
@Table(name = "exams")
data class Exams(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null
)
