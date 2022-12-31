

## How Does This Work

Four parts

* UseCase
* BackgroundExecutingUseCase
* TaskToBeCompleted-UseCase
* UseCaseExecutor

### UseCase

**Defines the core behaviour. input -> execute logic -> output**

The simple universal representation of all use cases - given an input, execute logic and get an output.

Created as an interface with generics so it covers all situations.

A single *execute()* method

Declares a contract between the UseCaseExecutor and all UseCases.
 
Ideally this should not reflect any implementation details but the keyword suspend is required

Note the asynchronous nature of the onResult parameter as a lambda.

 
### BackgroundExecutingUseCase

**Defines how the logic will be executed (coroutine)**

Extends UseCase interface, overrides the *execute()* method it inherits from UseCase and defines it will be run as a background coroutine.

This is a coroutine specific abstract class but you could have other mechanisms to deal with threading if desired.

This class handles the coroutine boiler plate code and hides that fact that it uses coroutines.

All the UseCases will extend this class


### TaskToBeCompleted-UseCase

**Defines the nature of the inputs and outputs, with the logic to be executed passed in as a Repository object**
 
Extends BackgroundExecutingUseCase, overrides the *executeInBackground()* method it inherits from BackgroundExecutingUseCase and defines the input and output types. 

A repository is provided that fits the requirements but remember the Domain layer knows nothing about the Repository layer.


### UseCaseExecutor

Provides a common mechanism for all ViewModels to interact with the Domain

