package com.wmccd.music_domain.clean_architecture.exception

class UnknownDomainException(throwable: Throwable): DomainException(throwable) {
    constructor(errorMessage: String): this(Throwable(errorMessage))
}