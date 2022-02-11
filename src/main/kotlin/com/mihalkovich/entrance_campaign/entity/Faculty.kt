package com.mihalkovich.entrance_campaign.entity

import javax.persistence.*

@Entity
@Table(name = "faculty")
data class Faculty(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @ManyToOne
    @JoinColumn(name = "university", nullable = false)
    var university: University? = null
)
