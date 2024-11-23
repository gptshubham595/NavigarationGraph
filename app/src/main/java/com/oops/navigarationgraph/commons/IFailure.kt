package com.oops.navigarationgraph.commons;

interface IFailure {
    abstract val errorModel: ErrorModel
}

sealed class Failure(
    open val exception: Exception? = null,
    override val errorModel: ErrorModel
) : IFailure {
    data class IOException(
        override val exception: Exception?,
        override val errorModel: ErrorModel = ErrorModel(errorTitle = "IOException")
    ) : Failure(exception, errorModel)

    data class HTTPException(
        override val exception: Exception?,
        override val errorModel: ErrorModel = ErrorModel(errorTitle = "HTTPException")
    ) : Failure(exception, errorModel)

    open class FeatureFailureException(
        override val exception: Exception?,
        override val errorModel: ErrorModel = ErrorModel(errorTitle = "FeatureFailureException")
    ) : Failure(exception, errorModel)

    data class GenericException(
        override val exception: Exception?,
        override val errorModel: ErrorModel = ErrorModel(
            errorTitle = "GenericException",
            exception = exception
        )
    ) :
        Failure(exception, errorModel)
}

sealed class FeatureFailure(
    override val exception: Exception?,
    override val errorModel: ErrorModel
) : Failure.FeatureFailureException(exception, errorModel) {

    class TodoApiCallFeatureFailed(
        override val exception: Exception?,
        override val errorModel: ErrorModel = ErrorModel(errorTitle = "TodoApiCallFailed")
    ) : FeatureFailure(exception, errorModel)

    class TodoDBCallFeatureFailed(
        override val exception: Exception?,
        override val errorModel: ErrorModel = ErrorModel(errorTitle = "TodoDBCallFailed")
    ) : FeatureFailure(exception, errorModel)

}
