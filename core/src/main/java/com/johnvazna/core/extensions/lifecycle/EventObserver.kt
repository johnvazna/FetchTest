package com.johnvazna.core.extensions.lifecycle

import androidx.lifecycle.Observer

/** */
class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
            System.gc()
        }
    }
}
