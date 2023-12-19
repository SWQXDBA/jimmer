package org.babyfish.jimmer.client.generator.ts;

import org.babyfish.jimmer.client.generator.CodeWriter;
import org.babyfish.jimmer.client.generator.Render;
import org.babyfish.jimmer.client.meta.Doc;
import org.babyfish.jimmer.client.runtime.ObjectType;
import org.babyfish.jimmer.client.runtime.Property;
import org.babyfish.jimmer.client.runtime.Type;

public class StaticTypeRender implements Render {

    private final String name;

    private final ObjectType type;

    public StaticTypeRender(String name, ObjectType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void export(CodeWriter writer) {
        writer
                .code("export type {")
                .code(name)
                .code("} from './")
                .code(name)
                .code("';\n");
    }

    @Override
    public void render(CodeWriter writer) {
        Doc doc = type.getDoc();
        writer.doc(doc).code("export interface ").code(name);
        if (!type.getArguments().isEmpty()) {
            writer.scope(CodeWriter.ScopeType.GENERIC, ", ", false, () -> {
                for (Type argument : type.getArguments()) {
                    writer.separator();
                    writer.typeRef(argument);
                }
            });
        }
        TypeScriptContext ctx = writer.getContext();
        writer.code(' ').scope(CodeWriter.ScopeType.OBJECT, "", true, () -> {
            for (Property property : type.getProperties().values()) {
                if (property.getDoc() != null) {
                    writer.doc(property.getDoc());
                } else if (doc != null) {
                    writer.doc(doc.getPropertyValueMap().get(property.getName()));
                }
                writer
                        .codeIf(!ctx.isMutable(), "readonly ")
                        .code(property.getName())
                        .code(": ")
                        .typeRef(property.getType())
                        .code(";\n");
            }
        });
        writer.code('\n');
    }
}
