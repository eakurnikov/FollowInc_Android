package com.eakurnikov.followinc.data.repos

/**
 * Created by eakurnikov on 04.12.2018.
 */

abstract class Repository<Dto, Entity> {

    protected abstract fun getEntityByDto(dto: Dto) : Entity
}