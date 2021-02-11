package com.example.thenamequiz.model

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class PersonViewModel (private val repository: PersonRepository) : ViewModel() {
    val allPersons: LiveData<List<Person>> = repository.allPersons.asLiveData()


    fun insert(person: Person) = viewModelScope.launch {
        repository.insertPerson(person)
        }
    }

    class PersonViewModelFactory(private val repository: PersonRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PersonViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }



    /*Here we've:

    Created a class called WordViewModel that gets the WordRepository as a parameter and extends ViewModel. The Repository is the only dependency that the ViewModel needs. If other classes would have been needed, they would have been passed in the constructor as well.
    Added a public LiveData member variable to cache the list of words.
    The LiveData is initialized with the allWords Flow from the Repository. We then converted the Flow to LiveData by calling asLiveData()
    Created a wrapper insert() method that calls the Repository's insert() method. In this way, the implementation of insert() is encapsulated from the UI. We're launching a new coroutine and calling the repository's insert, which is a suspend function. As mentioned, ViewModels have a coroutine scope based on their lifecycle called viewModelScope, which we use here.
    To create the ViewModel we implement a ViewModelProvider.Factory that gets as a parameter the dependencies needed to create WordViewModel: the WordRepository.
    By using viewModels and ViewModelProvider.Factory then the framework will take care of the lifecycle of the ViewModel. It will survive configuration changes and even if the Activity is recreated, you'll always get the right instance of the WordViewModel class.
    Warning: Don't keep a reference to a context that has a shorter lifecycle than your ViewModel! Examples are:

    Activity
    Fragment
    View
    Keeping a reference can cause a memory leak, e.g. the ViewModel has a reference to a destroyed Activity! All these objects can be destroyed by the operating system and recreated when there's a configuration change, and this can happen many times during the lifecycle of a ViewModel.

    Important: ViewModels don't survive the app's process being killed in the background when the OS needs more resources. For UI data that needs to survive process death due to running out of resources, you can use the Saved State module for ViewModels. Learn more here.

    To learn more about ViewModel classes, watch the Android Jetpack: ViewModel video.

    To learn more about coroutines, check out the Coroutines codelab.

    Back*/
