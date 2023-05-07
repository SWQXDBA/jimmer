package org.babyfish.jimmer.ksp.generator

import com.fasterxml.jackson.annotation.JsonIgnore
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.asClassName
import org.babyfish.jimmer.*
import org.babyfish.jimmer.meta.ImmutablePropCategory
import org.babyfish.jimmer.meta.ImmutableType
import org.babyfish.jimmer.runtime.*
import org.babyfish.jimmer.sql.*
import org.babyfish.jimmer.impl.validation.Validator
import org.babyfish.jimmer.sql.collection.ManyToManyViewList
import java.math.BigDecimal
import java.math.BigInteger
import java.util.regex.Pattern

internal const val DRAFT = "Draft"
internal const val PRODUCER = "$"
internal const val IMPLEMENTOR = "Implementor"
internal const val IMPL = "Impl"
internal const val DRAFT_IMPL = "DraftImpl"
internal const val DRAFT_FIELD_EMAIL_PATTERN = "__email_pattern"
internal const val PROPS = "Props"
internal const val FETCHER = "Fetcher"
internal const val FETCHER_DSL = "FetcherDsl"

internal val CLONEABLE_CLASS_NAME = Cloneable::class.asClassName()
internal val JVM_STATIC_CLASS_NAME = JvmStatic::class.asClassName()
internal val JSON_IGNORE_CLASS_NAME = JsonIgnore::class.asClassName()
internal val INTERNAL_TYPE_CLASS_NAME = Internal::class.asClassName()
internal val IMMUTABLE_PROP_CATEGORY_CLASS_NAME = ImmutablePropCategory::class.asClassName()
internal val IMMUTABLE_TYPE_CLASS_NAME = ImmutableType::class.asClassName()
internal val DRAFT_CONSUMER_CLASS_NAME = DraftConsumer::class.asClassName()
internal val IMMUTABLE_SPI_CLASS_NAME = ImmutableSpi::class.asClassName()
internal val IMMUTABLE_OBJECTS_CLASS_NAME = ImmutableObjects::class.asClassName()
internal val UNLOADED_EXCEPTION_CLASS_NAME = UnloadedException::class.asClassName()
internal val SYSTEM_CLASS_NAME = System::class.asClassName()
internal val DRAFT_CLASS_NAME = Draft::class.asClassName()
internal val DRAFT_SPI_CLASS_NAME = DraftSpi::class.asClassName()
internal val DRAFT_CONTEXT_CLASS_NAME = DraftContext::class.asClassName()
internal val NON_SHARED_LIST_CLASS_NAME = NonSharedList::class.asClassName()
internal val CIRCULAR_REFERENCE_EXCEPTION_CLASS_NAME = CircularReferenceException::class.asClassName()
internal val IMMUTABLE_CREATOR_CLASS_NAME = ClassName("org.babyfish.jimmer.kt", "ImmutableCreator")
internal val DSL_SCOPE_CLASS_NAME = ClassName("org.babyfish.jimmer.kt", "DslScope")
internal val BIG_DECIMAL_CLASS_NAME = BigDecimal::class.asClassName()
internal val BIG_INTEGER_CLASS_NAME = BigInteger::class.asClassName()
internal val PATTERN_CLASS_NAME = Pattern::class.asClassName()
internal val VALIDATOR_CLASS_NAME = Validator::class.asClassName()
internal val ONE_TO_ONE_CLASS_NAME = OneToOne::class.asClassName()
internal val MANY_TO_ONE_CLASS_NAME = ManyToOne::class.asClassName()
internal val ONE_TO_MANY_CLASS_NAME = OneToMany::class.asClassName()
internal val MANY_TO_MANY_CLASS_NAME = ManyToMany::class.asClassName()
internal val MANY_TO_MANY_VIEW_CLASS_NAME = ManyToManyView::class.asClassName()
internal val MANY_TO_MANY_VIEW_LIST_CLASS_NAME = ManyToManyViewList::class.asClassName()
internal val K_PROPS_CLASS_NAME = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KProps"
)
internal val K_NON_NULL_PROPS_CLASS_NAME = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KNonNullProps"
)
internal val K_NULLABLE_PROPS_CLASS_NAME = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KNullableProps"
)
internal val K_NON_NULL_TABLE_CLASS_NAME = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KNonNullTable"
)
internal val K_NULLABLE_TABLE_CLASS_NAME = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KNullableTable"
)
internal val K_NON_NULL_REMOTE_REF = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KRemoteRef", "NonNull"
)
internal val K_NULLABLE_REMOTE_REF = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KRemoteRef", "Nullable"
)
internal val K_REMOTE_REF = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KRemoteRef"
)
internal val K_REMOTE_REF_IMPLEMENTOR = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table.impl",
    "KRemoteRefImplementor"
)
internal val K_NON_NULL_TABLE_CLASS_NAME_EX = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KNonNullTableEx"
)
internal val K_NULLABLE_TABLE_CLASS_NAME_EX = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KNullableTableEx"
)
internal val K_TABLE_EX_CLASS_NAME = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.table",
    "KTableEx"
)
internal val K_NON_NULL_PROP_EXPRESSION = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.expression",
    "KNonNullPropExpression"
)
internal val K_NULLABLE_PROP_EXPRESSION = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.expression",
    "KNullablePropExpression"
)
internal val K_NON_NULL_PROP_EXPRESSION_IMPLEMENTOR = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.expression.spi",
    "KNonNullPropExpressionImplementor"
)
internal val K_NULLABLE_PROP_EXPRESSION_IMPLEMENTOR = ClassName(
    "org.babyfish.jimmer.sql.kt.ast.expression.spi",
    "KNullablePropExpressionImplementor"
)
internal val FETCHER_CLASS_NAME = ClassName(
    "org.babyfish.jimmer.sql.fetcher",
    "Fetcher"
)
internal val FETCHER_IMPL_CLASS_NAME = ClassName(
    "org.babyfish.jimmer.sql.fetcher.impl",
    "FetcherImpl"
)
internal val JAVA_FIELD_CONFIG_UTILS = ClassName(
    "org.babyfish.jimmer.sql.kt.fetcher.impl",
    "JavaFieldConfigUtils"
)
internal val K_FIELD_DSL = ClassName(
    "org.babyfish.jimmer.sql.kt.fetcher",
    "KFieldDsl"
)
internal val K_LIST_FIELD_DSL = ClassName(
    "org.babyfish.jimmer.sql.kt.fetcher",
    "KListFieldDsl"
)
internal val K_RECURSIVE_FIELD_DSL = ClassName(
    "org.babyfish.jimmer.sql.kt.fetcher",
    "KRecursiveFieldDsl"
)
internal val K_RECURSIVE_LIST_FIELD_DSL = ClassName(
    "org.babyfish.jimmer.sql.kt.fetcher",
    "KRecursiveListFieldDsl"
)
internal val FETCHER_CREATOR_CLASS_NAME = ClassName(
    "org.babyfish.jimmer.sql.kt.fetcher",
    "FetcherCreator"
)
internal val SELECTION_CLASS_NAME =
    ClassName(
        "org.babyfish.jimmer.sql.ast",
        "Selection"
    )
internal val NEW_FETCHER_FUN_CLASS_NAME =
    ClassName(
        "org.babyfish.jimmer.sql.kt.fetcher",
        "newFetcher"
    )
internal val ENTITY_MANAGER_CLASS_NAME =
    ClassName(
        "org.babyfish.jimmer.sql.runtime",
        "EntityManager"
    )

internal const val KEY_FULL_NAME = "org.babyfish.jimmer.sql.Key"
internal const val JIMMER_MODULE = "JimmerModule"

internal const val UNMODIFIED = "(__modified ?: __base!!)"
internal const val MODIFIED = "(__modified ?: __base!!.clone())\n.also { __modified = it }"

internal const val EMAIL_PATTERN = "^[^@]+@[^@]+\$"