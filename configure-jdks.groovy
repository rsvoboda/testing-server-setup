import jenkins.model.*
import hudson.model.*
import hudson.tools.*

def inst = Jenkins.getInstance()

def desc = inst.getDescriptor("hudson.model.JDK")

def versions = [
  "java-1.8.0-openjdk-system": "/usr/lib/jvm/java-1.8.0-openjdk",
  "java-11-openjdk-system": "/usr/lib/jvm/java-11-openjdk",
  "java-11-openjdk": "/var/lib/jenkins/.sdkman/candidates/java/11.0.5-open",
  "java-12-openjdk": "/var/lib/jenkins/.sdkman/candidates/java/12.0.2-open",
  "java-13-openjdk": "/var/lib/jenkins/.sdkman/candidates/java/13.0.1-open",
  "java-14-ea": "/var/lib/jenkins/.sdkman/candidates/java/14.ea.28-open",
  "java-15-ea": "/var/lib/jenkins/.sdkman/candidates/java/15.ea.2-open",
  "graalvm-19.2.1-grl": "/var/lib/jenkins/.sdkman/candidates/java/19.2.1-grl",
  "graalvm-19.3.0.2.r8-grl": "/var/lib/jenkins/.sdkman/candidates/java/19.3.0.2.r8-grl",
  "graalvm": "/var/lib/jenkins/.sdkman/candidates/java/19.3.0.2.r8-grl",
]
def installations = [];

for (v in versions) {
  def installation = new JDK(v.key, v.value)
  installations.push(installation)
}

desc.setInstallations(installations.toArray(new JDK[0]))
desc.save()