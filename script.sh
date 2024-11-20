#!/bin/bash

# <groupId>com.cthiebaud</groupId>
# <artifactId>password-validator</artifactId>
# <version>1.0.0-SNAPSHOT</version>

# Define paths
TARGET_DIR="target"
GROUP_ID="com.cthiebaud"
ARTIFACT_ID="password-validator"
VERSION="1.0.0-SNAPSHOT"

# Create a JAR name with groupId included, using '-' as a separator
OUTPUT_JAR="$TARGET_DIR/${GROUP_ID//./-}-$ARTIFACT_ID-$VERSION.jar"

# Ensure the target directory exists
mkdir -p "$TARGET_DIR"

# Download password-validator.jar directly into the target directory
mvn dependency:copy \
    -Dartifact="$GROUP_ID:$ARTIFACT_ID:$VERSION" \
    -DoutputDirectory="$TARGET_DIR" \
    -Dmdep.stripVersion=false

# Rename the downloaded JAR to include the groupId
DOWNLOADED_JAR=$(find "$TARGET_DIR" -name "$ARTIFACT_ID-*.jar" | head -n 1)

if [[ -z "$DOWNLOADED_JAR" ]]; then
    echo "Error: Failed to download $ARTIFACT_ID to the target directory."
    exit 1
fi

mv "$DOWNLOADED_JAR" "$OUTPUT_JAR"

if [[ ! -f "$OUTPUT_JAR" ]]; then
    echo "Error: Failed to rename downloaded JAR to include groupId."
    exit 1
fi

# Check if an argument is provided
if [[ $# -gt 0 ]]; then
    # Parse the argument as groupId:artifactId:version
    STUDENT_DEP="$1"

    # Extract the groupId, artifactId, and version from the argument
    STUDENT_GROUP_ID=$(echo "$STUDENT_DEP" | cut -d':' -f1)
    STUDENT_ARTIFACT_ID=$(echo "$STUDENT_DEP" | cut -d':' -f2)
    STUDENT_VERSION=$(echo "$STUDENT_DEP" | cut -d':' -f3)

    # Create a name for the student's JAR
    STUDENT_JAR="$TARGET_DIR/${STUDENT_GROUP_ID//./-}-$STUDENT_ARTIFACT_ID-$STUDENT_VERSION.jar"

    # Download the student's JAR
    mvn dependency:copy \
        -Dartifact="$STUDENT_DEP" \
        -DoutputDirectory="$TARGET_DIR" \
        -Dmdep.stripVersion=false

    # Rename the student's JAR to include groupId
    DOWNLOADED_STUDENT_JAR=$(find "$TARGET_DIR" -name "$STUDENT_ARTIFACT_ID-*.jar" | head -n 1)

    if [[ -z "$DOWNLOADED_STUDENT_JAR" ]]; then
        echo "Error: Failed to download student JAR: $STUDENT_DEP"
        exit 1
    fi

    mv "$DOWNLOADED_STUDENT_JAR" "$STUDENT_JAR"

    if [[ ! -f "$STUDENT_JAR" ]]; then
        echo "Error: Failed to rename student JAR to include groupId."
        exit 1
    fi
else
    # Locate the first student JAR in the target directory
    STUDENT_JAR=$(find target -name "*.jar" ! -name "$(basename "$OUTPUT_JAR")" | head -n 1)

    if [[ -z "$STUDENT_JAR" ]]; then
        echo "Error: No student JAR file found in the target directory."
        exit 1
    fi
fi

# Run the Tester with the student's JAR
echo java -jar "$OUTPUT_JAR" "$STUDENT_JAR"
java -jar "$OUTPUT_JAR" "$STUDENT_JAR"
