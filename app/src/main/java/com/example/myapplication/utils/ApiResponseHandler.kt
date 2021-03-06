package com.example.myapplication.utils

import com.example.myapplication.utils.ApiResult.*

abstract class ApiResponseHandler<ViewState, Data>(
    private val response: ApiResult<Data?>,
    private val stateEvent: StateEvent?
) {

    suspend fun getResult(): DataState<ViewState>? {

        return when (response) {
            is GenericError -> {
                println(
                    "ApiResponseHandler : ----------Network Error-----------\n" +
                            "Error Code : ${response.code} \n" +
                            "Error Message : ${response.errorMessage}"
                )
                DataState.error(
                    response = Response(
                        message = "${stateEvent?.errorInfo()}\n${response.errorMessage.toString()}",
                        uiType = UiType.Dialog,
                        messageType = MessageType.Error
                    ),
                    stateEvent = stateEvent
                )
            }

            is NetworkError -> {
                println(
                    "ApiResponseHandler : ----------Network Error-----------\n" +
                            "Error : No network connection"
                )
                DataState.error(
                    response = Response(
                        message = NETWORK_ERROR,
                        uiType = UiType.SnackBar,
                        messageType = MessageType.Error
                    ),
                    stateEvent = stateEvent
                )
            }

            is Success -> {
                if (response.value == null) {
                    println(
                        "ApiResponseHandler : ----------Network Error-----------\n" +
                                "Error : Network Data is null"
                    )
                    DataState.error(
                        response = Response(
                            message = NETWORK_DATA_NULL,
                            uiType = UiType.SnackBar,
                            messageType = MessageType.Error
                        ),
                        stateEvent = stateEvent
                    )
                } else {
                    handleSuccess(resultObj = response.value)
                }
            }
        }
    }

    abstract suspend fun handleSuccess(resultObj: Data): DataState<ViewState>?

    companion object {
        const val NETWORK_ERROR = "Network error"
        const val NETWORK_DATA_NULL = "Network data is null"
    }
}