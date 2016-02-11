package satnami.com.mvvm.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by satnami on 12/2/2016.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerDataManager {
}
